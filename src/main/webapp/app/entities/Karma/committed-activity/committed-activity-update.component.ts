import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { CommittedActivityService } from './committed-activity.service';
import { IActivity } from 'app/shared/model/Karma/activity.model';
import { ActivityService } from 'app/entities/Karma/activity';
import { IUser, UserService } from 'app/core';

@Component({
  selector: 'jhi-committed-activity-update',
  templateUrl: './committed-activity-update.component.html'
})
export class CommittedActivityUpdateComponent implements OnInit {
  committedActivity: ICommittedActivity;
  isSaving: boolean;

  activities: IActivity[];

  users: IUser[];

  committedactivities: ICommittedActivity[];
  createdDateAndTime: string;

  constructor(
    private jhiAlertService: JhiAlertService,
    private committedActivityService: CommittedActivityService,
    private activityService: ActivityService,
    private userService: UserService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ committedActivity }) => {
      this.committedActivity = committedActivity;
      this.createdDateAndTime =
        this.committedActivity.createdDateAndTime != null ? this.committedActivity.createdDateAndTime.format(DATE_TIME_FORMAT) : null;
    });
    this.activityService.query().subscribe(
      (res: HttpResponse<IActivity[]>) => {
        this.activities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.userService.query().subscribe(
      (res: HttpResponse<IUser[]>) => {
        this.users = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.committedActivityService.query().subscribe(
      (res: HttpResponse<ICommittedActivity[]>) => {
        this.committedactivities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.committedActivity.createdDateAndTime = this.createdDateAndTime != null ? moment(this.createdDateAndTime, DATE_TIME_FORMAT) : null;
    if (this.committedActivity.id !== undefined) {
      this.subscribeToSaveResponse(this.committedActivityService.update(this.committedActivity));
    } else {
      this.subscribeToSaveResponse(this.committedActivityService.create(this.committedActivity));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<ICommittedActivity>>) {
    result.subscribe((res: HttpResponse<ICommittedActivity>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

  trackActivityById(index: number, item: IActivity) {
    return item.id;
  }

  trackUserById(index: number, item: IUser) {
    return item.id;
  }

  trackCommittedActivityById(index: number, item: ICommittedActivity) {
    return item.id;
  }
}
