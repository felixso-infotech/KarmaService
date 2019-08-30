import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { IActivity } from 'app/shared/model/Karma/activity.model';
import { ActivityService } from './activity.service';
import { IChallenge } from 'app/shared/model/Karma/challenge.model';
import { ChallengeService } from 'app/entities/Karma/challenge';
import { IDimension } from 'app/shared/model/Karma/dimension.model';
import { DimensionService } from 'app/entities/Karma/dimension';

@Component({
  selector: 'jhi-activity-update',
  templateUrl: './activity-update.component.html'
})
export class ActivityUpdateComponent implements OnInit {
  activity: IActivity;
  isSaving: boolean;

  challenges: IChallenge[];

  dimensions: IDimension[];
  createdDateAndTime: string;

  constructor(
    private jhiAlertService: JhiAlertService,
    private activityService: ActivityService,
    private challengeService: ChallengeService,
    private dimensionService: DimensionService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ activity }) => {
      this.activity = activity;
      this.createdDateAndTime = this.activity.createdDateAndTime != null ? this.activity.createdDateAndTime.format(DATE_TIME_FORMAT) : null;
    });
    this.challengeService.query().subscribe(
      (res: HttpResponse<IChallenge[]>) => {
        this.challenges = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.dimensionService.query().subscribe(
      (res: HttpResponse<IDimension[]>) => {
        this.dimensions = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.activity.createdDateAndTime = this.createdDateAndTime != null ? moment(this.createdDateAndTime, DATE_TIME_FORMAT) : null;
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

  trackChallengeById(index: number, item: IChallenge) {
    return item.id;
  }

  trackDimensionById(index: number, item: IDimension) {
    return item.id;
  }

  getSelected(selectedVals: Array<any>, option: any) {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
