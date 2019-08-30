import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { IMedia } from 'app/shared/model/Karma/media.model';
import { MediaService } from './media.service';
import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { CommittedActivityService } from 'app/entities/Karma/committed-activity';
import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';
import { CompletedChallengeService } from 'app/entities/Karma/completed-challenge';

@Component({
  selector: 'jhi-media-update',
  templateUrl: './media-update.component.html'
})
export class MediaUpdateComponent implements OnInit {
  media: IMedia;
  isSaving: boolean;

  committedactivities: ICommittedActivity[];

  completedchallenges: ICompletedChallenge[];

  constructor(
    private dataUtils: JhiDataUtils,
    private jhiAlertService: JhiAlertService,
    private mediaService: MediaService,
    private committedActivityService: CommittedActivityService,
    private completedChallengeService: CompletedChallengeService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ media }) => {
      this.media = media;
    });
    this.committedActivityService.query().subscribe(
      (res: HttpResponse<ICommittedActivity[]>) => {
        this.committedactivities = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.completedChallengeService.query().subscribe(
      (res: HttpResponse<ICompletedChallenge[]>) => {
        this.completedchallenges = res.body;
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

  trackCommittedActivityById(index: number, item: ICommittedActivity) {
    return item.id;
  }

  trackCompletedChallengeById(index: number, item: ICompletedChallenge) {
    return item.id;
  }
}
