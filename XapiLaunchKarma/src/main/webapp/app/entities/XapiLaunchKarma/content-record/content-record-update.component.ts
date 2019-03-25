import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';
import { ContentRecordService } from './content-record.service';

@Component({
  selector: 'jhi-content-record-update',
  templateUrl: './content-record-update.component.html'
})
export class ContentRecordUpdateComponent implements OnInit {
  contentRecord: IContentRecord;
  isSaving: boolean;
  accessed: string;
  created: string;

  constructor(private contentRecordService: ContentRecordService, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ contentRecord }) => {
      this.contentRecord = contentRecord;
      this.accessed = this.contentRecord.accessed != null ? this.contentRecord.accessed.format(DATE_TIME_FORMAT) : null;
      this.created = this.contentRecord.created != null ? this.contentRecord.created.format(DATE_TIME_FORMAT) : null;
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.contentRecord.accessed = this.accessed != null ? moment(this.accessed, DATE_TIME_FORMAT) : null;
    this.contentRecord.created = this.created != null ? moment(this.created, DATE_TIME_FORMAT) : null;
    if (this.contentRecord.id !== undefined) {
      this.subscribeToSaveResponse(this.contentRecordService.update(this.contentRecord));
    } else {
      this.subscribeToSaveResponse(this.contentRecordService.create(this.contentRecord));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IContentRecord>>) {
    result.subscribe((res: HttpResponse<IContentRecord>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }
}
