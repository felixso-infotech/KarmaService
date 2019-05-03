import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { IMedia } from 'app/shared/model/KarmaApp/media.model';
import { MediaService } from './media.service';
import { IActivity } from 'app/shared/model/KarmaApp/activity.model';
import { ActivityService } from 'app/entities/KarmaApp/activity';
import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';
import { CompletedActivityService } from 'app/entities/KarmaApp/completed-activity';

@Component({
  selector: 'jhi-media-update',
  templateUrl: './media-update.component.html'
})
export class MediaUpdateComponent implements OnInit {
  media: IMedia;
  isSaving: boolean;

  activities: IActivity[];

  completedactivities: ICompletedActivity[];

  constructor(
    private dataUtils: JhiDataUtils,
    private jhiAlertService: JhiAlertService,
    private mediaService: MediaService,
    private activityService: ActivityService,
    private completedActivityService: CompletedActivityService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ media }) => {
      this.media = media;
    });
    this.activityService.query().subscribe(
      (res: HttpResponse<IActivity[]>) => {
        this.activities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.completedActivityService.query().subscribe(
      (res: HttpResponse<ICompletedActivity[]>) => {
        this.completedactivities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  byteSize(field) {
    return this.dataUtils.byteSize(field);
  }

  openFile(contentType, field) {
    return this.dataUtils.openFile(contentType, field);
  }

  setFileData(event, entity, field, isImage) {
    this.dataUtils.setFileData(event, entity, field, isImage);
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    if (this.media.id !== undefined) {
      this.subscribeToSaveResponse(this.mediaService.update(this.media));
    } else {
      this.subscribeToSaveResponse(this.mediaService.create(this.media));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IMedia>>) {
    result.subscribe((res: HttpResponse<IMedia>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

  trackCompletedActivityById(index: number, item: ICompletedActivity) {
    return item.id;
  }
}
