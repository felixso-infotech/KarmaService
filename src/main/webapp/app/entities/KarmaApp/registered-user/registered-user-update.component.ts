import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IRegisteredUser } from 'app/shared/model/KarmaApp/registered-user.model';
import { RegisteredUserService } from './registered-user.service';
import { IMedia } from 'app/shared/model/KarmaApp/media.model';
import { MediaService } from 'app/entities/KarmaApp/media';

@Component({
  selector: 'jhi-registered-user-update',
  templateUrl: './registered-user-update.component.html'
})
export class RegisteredUserUpdateComponent implements OnInit {
  registeredUser: IRegisteredUser;
  isSaving: boolean;

  profilepics: IMedia[];

  constructor(
    private jhiAlertService: JhiAlertService,
    private registeredUserService: RegisteredUserService,
    private mediaService: MediaService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ registeredUser }) => {
      this.registeredUser = registeredUser;
    });
    this.mediaService.query({ filter: 'registereduser-is-null' }).subscribe(
      (res: HttpResponse<IMedia[]>) => {
        if (!this.registeredUser.profilePicId) {
          this.profilepics = res.body;
        } else {
          this.mediaService.find(this.registeredUser.profilePicId).subscribe(
            (subRes: HttpResponse<IMedia>) => {
              this.profilepics = [subRes.body].concat(res.body);
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

  trackMediaById(index: number, item: IMedia) {
    return item.id;
  }
}
