import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

@Component({
  selector: 'jhi-completed-challenge-detail',
  templateUrl: './completed-challenge-detail.component.html'
})
export class CompletedChallengeDetailComponent implements OnInit {
  completedChallenge: ICompletedChallenge;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ completedChallenge }) => {
      this.completedChallenge = completedChallenge;
    });
  }

  previousState() {
    window.history.back();
  }
}
