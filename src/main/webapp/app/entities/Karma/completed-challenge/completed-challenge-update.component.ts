import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';
import { CompletedChallengeService } from './completed-challenge.service';
import { IChallenge } from 'app/shared/model/Karma/challenge.model';
import { ChallengeService } from 'app/entities/Karma/challenge';
import { IUser, UserService } from 'app/core';

@Component({
  selector: 'jhi-completed-challenge-update',
  templateUrl: './completed-challenge-update.component.html'
})
export class CompletedChallengeUpdateComponent implements OnInit {
  completedChallenge: ICompletedChallenge;
  isSaving: boolean;

  challenges: IChallenge[];

  users: IUser[];
  createdDate: string;

  constructor(
    private jhiAlertService: JhiAlertService,
    private completedChallengeService: CompletedChallengeService,
    private challengeService: ChallengeService,
    private userService: UserService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ completedChallenge }) => {
      this.completedChallenge = completedChallenge;
      this.createdDate = this.completedChallenge.createdDate != null ? this.completedChallenge.createdDate.format(DATE_TIME_FORMAT) : null;
    });
    this.challengeService.query().subscribe(
      (res: HttpResponse<IChallenge[]>) => {
        this.challenges = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
    this.userService.query().subscribe(
      (res: HttpResponse<IUser[]>) => {
        this.users = res.body;
      },
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    this.completedChallenge.createdDate = this.createdDate != null ? moment(this.createdDate, DATE_TIME_FORMAT) : null;
    if (this.completedChallenge.id !== undefined) {
      this.subscribeToSaveResponse(this.completedChallengeService.update(this.completedChallenge));
    } else {
      this.subscribeToSaveResponse(this.completedChallengeService.create(this.completedChallenge));
    }
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<ICompletedChallenge>>) {
    result.subscribe((res: HttpResponse<ICompletedChallenge>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

  trackChallengeById(index: number, item: IChallenge) {
    return item.id;
  }

  trackUserById(index: number, item: IUser) {
    return item.id;
  }
}
