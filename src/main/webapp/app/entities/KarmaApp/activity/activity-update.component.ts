import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IActivity } from 'app/shared/model/KarmaApp/activity.model';
import { ActivityService } from './activity.service';
import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';
import { InstructionVideoService } from 'app/entities/KarmaApp/instruction-video';

@Component({
  selector: 'jhi-activity-update',
  templateUrl: './activity-update.component.html'
})
export class ActivityUpdateComponent implements OnInit {
  activity: IActivity;
  isSaving: boolean;

  instructionvideos: IInstructionVideo[];

  constructor(
    private jhiAlertService: JhiAlertService,
    private activityService: ActivityService,
    private instructionVideoService: InstructionVideoService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ activity }) => {
      this.activity = activity;
    });
    this.instructionVideoService.query({ filter: 'activity-is-null' }).subscribe(
      (res: HttpResponse<IInstructionVideo[]>) => {
        if (!this.activity.instructionVideoId) {
          this.instructionvideos = res.body;
        } else {
          this.instructionVideoService.find(this.activity.instructionVideoId).subscribe(
            (subRes: HttpResponse<IInstructionVideo>) => {
              this.instructionvideos = [subRes.body].concat(res.body);
            },
            (subRes: HttpErrorResponse) => this.onError(subRes.message)
          );
        }
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    if (this.activity.id !== undefined) {
      this.subscribeToSaveResponse(this.activityService.update(this.activity));
    } else {
      this.subscribeToSaveResponse(this.activityService.create(this.activity));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IActivity>>) {
    result.subscribe((res: HttpResponse<IActivity>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

  trackInstructionVideoById(index: number, item: IInstructionVideo) {
    return item.id;
  }
}
