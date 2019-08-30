import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IChallenge } from 'app/shared/model/Karma/challenge.model';
import { ChallengeService } from './challenge.service';

@Component({
  selector: 'jhi-challenge-update',
  templateUrl: './challenge-update.component.html'
})
export class ChallengeUpdateComponent implements OnInit {
  challenge: IChallenge;
  isSaving: boolean;
  createdDateAndTime: string;

  constructor(private challengeService: ChallengeService, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ challenge }) => {
      this.challenge = challenge;
      this.createdDateAndTime =
        this.challenge.createdDateAndTime != null ? this.challenge.createdDateAndTime.format(DATE_TIME_FORMAT) : null;
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.challenge.createdDateAndTime = this.createdDateAndTime != null ? moment(this.createdDateAndTime, DATE_TIME_FORMAT) : null;
    if (this.challenge.id !== undefined) {
      this.subscribeToSaveResponse(this.challengeService.update(this.challenge));
    } else {
      this.subscribeToSaveResponse(this.challengeService.create(this.challenge));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<IChallenge>>) {
    result.subscribe((res: HttpResponse<IChallenge>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  private onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  private onSaveError() {
    this.isSaving = false;
  }
}
