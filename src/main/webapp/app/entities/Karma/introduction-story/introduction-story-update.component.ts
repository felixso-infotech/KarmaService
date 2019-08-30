import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';
import { IntroductionStoryService } from './introduction-story.service';
import { IActivity } from 'app/shared/model/Karma/activity.model';
import { ActivityService } from 'app/entities/Karma/activity';

@Component({
  selector: 'jhi-introduction-story-update',
  templateUrl: './introduction-story-update.component.html'
})
export class IntroductionStoryUpdateComponent implements OnInit {
  introductionStory: IIntroductionStory;
  isSaving: boolean;

  activities: IActivity[];

  constructor(
    private dataUtils: JhiDataUtils,
    private jhiAlertService: JhiAlertService,
    private introductionStoryService: IntroductionStoryService,
    private activityService: ActivityService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ introductionStory }) => {
      this.introductionStory = introductionStory;
    });
    this.activityService.query().subscribe(
      (res: HttpResponse<IActivity[]>) => {
        this.activities = res.body;
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
    if (this.introductionStory.id !== undefined) {
      this.subscribeToSaveResponse(this.introductionStoryService.update(this.introductionStory));
    } else {
      this.subscribeToSaveResponse(this.introductionStoryService.create(this.introductionStory));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IIntroductionStory>>) {
    result.subscribe((res: HttpResponse<IIntroductionStory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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
}
