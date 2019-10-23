import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiDataUtils } from 'ng-jhipster';

import { IRegisteredUser } from 'app/shared/model/Karma/registered-user.model';
import { RegisteredUserService } from './registered-user.service';

@Component({
  selector: 'jhi-registered-user-update',
  templateUrl: './registered-user-update.component.html'
})
export class RegisteredUserUpdateComponent implements OnInit {
  registeredUser: IRegisteredUser;
  isSaving: boolean;
  createdDate: string;

  constructor(
    private dataUtils: JhiDataUtils,
    private registeredUserService: RegisteredUserService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ registeredUser }) => {
      this.registeredUser = registeredUser;
      this.createdDate = this.registeredUser.createdDate != null ? this.registeredUser.createdDate.format(DATE_TIME_FORMAT) : null;
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
    this.registeredUser.createdDate = this.createdDate != null ? moment(this.createdDate, DATE_TIME_FORMAT) : null;
    if (this.registeredUser.id !== undefined) {
      this.subscribeToSaveResponse(this.registeredUserService.update(this.registeredUser));
    } else {
      this.subscribeToSaveResponse(this.registeredUserService.create(this.registeredUser));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IRegisteredUser>>) {
    result.subscribe((res: HttpResponse<IRegisteredUser>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }
}
