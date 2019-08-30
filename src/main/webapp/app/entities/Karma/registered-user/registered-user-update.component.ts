import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { IRegisteredUser } from 'app/shared/model/Karma/registered-user.model';
import { RegisteredUserService } from './registered-user.service';
import { IUser, UserService } from 'app/core';

@Component({
  selector: 'jhi-registered-user-update',
  templateUrl: './registered-user-update.component.html'
})
export class RegisteredUserUpdateComponent implements OnInit {
  registeredUser: IRegisteredUser;
  isSaving: boolean;

  users: IUser[];

  constructor(
    private dataUtils: JhiDataUtils,
    private jhiAlertService: JhiAlertService,
    private registeredUserService: RegisteredUserService,
    private userService: UserService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ registeredUser }) => {
      this.registeredUser = registeredUser;
    });
    this.userService.query().subscribe(
      (res: HttpResponse<IUser[]>) => {
        this.users = res.body;
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

  private onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackUserById(index: number, item: IUser) {
    return item.id;
  }
}
