import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';
import { CompletedActivityService } from './completed-activity.service';
import { IRegisteredUser } from 'app/shared/model/KarmaApp/registered-user.model';
import { RegisteredUserService } from 'app/entities/KarmaApp/registered-user';
import { IActivity } from 'app/shared/model/KarmaApp/activity.model';
import { ActivityService } from 'app/entities/KarmaApp/activity';

@Component({
  selector: 'jhi-completed-activity-update',
  templateUrl: './completed-activity-update.component.html'
})
export class CompletedActivityUpdateComponent implements OnInit {
  completedActivity: ICompletedActivity;
  isSaving: boolean;

  registeredusers: IRegisteredUser[];

  activities: IActivity[];

  constructor(
    private jhiAlertService: JhiAlertService,
    private completedActivityService: CompletedActivityService,
    private registeredUserService: RegisteredUserService,
    private activityService: ActivityService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ completedActivity }) => {
      this.completedActivity = completedActivity;
    });
    this.registeredUserService.query().subscribe(
      (res: HttpResponse<IRegisteredUser[]>) => {
        this.registeredusers = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.activityService.query().subscribe(
      (res: HttpResponse<IActivity[]>) => {
        this.activities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    if (this.completedActivity.id !== undefined) {
      this.subscribeToSaveResponse(this.completedActivityService.update(this.completedActivity));
    } else {
      this.subscribeToSaveResponse(this.completedActivityService.create(this.completedActivity));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<ICompletedActivity>>) {
    result.subscribe((res: HttpResponse<ICompletedActivity>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackRegisteredUserById(index: number, item: IRegisteredUser) {
    return item.id;
  }

  trackActivityById(index: number, item: IActivity) {
    return item.id;
  }
}
