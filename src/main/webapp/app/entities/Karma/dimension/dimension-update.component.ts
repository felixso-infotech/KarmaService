import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IDimension } from 'app/shared/model/Karma/dimension.model';
import { DimensionService } from './dimension.service';
import { IActivity } from 'app/shared/model/Karma/activity.model';
import { ActivityService } from 'app/entities/Karma/activity';

@Component({
  selector: 'jhi-dimension-update',
  templateUrl: './dimension-update.component.html'
})
export class DimensionUpdateComponent implements OnInit {
  dimension: IDimension;
  isSaving: boolean;

  activities: IActivity[];

  constructor(
    private jhiAlertService: JhiAlertService,
    private dimensionService: DimensionService,
    private activityService: ActivityService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ dimension }) => {
      this.dimension = dimension;
    });
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
    if (this.dimension.id !== undefined) {
      this.subscribeToSaveResponse(this.dimensionService.update(this.dimension));
    } else {
      this.subscribeToSaveResponse(this.dimensionService.create(this.dimension));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IDimension>>) {
    result.subscribe((res: HttpResponse<IDimension>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
