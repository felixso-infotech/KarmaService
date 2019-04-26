import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';
import { InstructionVideoService } from './instruction-video.service';

@Component({
  selector: 'jhi-instruction-video-update',
  templateUrl: './instruction-video-update.component.html'
})
export class InstructionVideoUpdateComponent implements OnInit {
  instructionVideo: IInstructionVideo;
  isSaving: boolean;

  constructor(
    private dataUtils: JhiDataUtils,
    private instructionVideoService: InstructionVideoService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ instructionVideo }) => {
      this.instructionVideo = instructionVideo;
    });
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
    if (this.instructionVideo.id !== undefined) {
      this.subscribeToSaveResponse(this.instructionVideoService.update(this.instructionVideo));
    } else {
      this.subscribeToSaveResponse(this.instructionVideoService.create(this.instructionVideo));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IInstructionVideo>>) {
    result.subscribe((res: HttpResponse<IInstructionVideo>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }
}
