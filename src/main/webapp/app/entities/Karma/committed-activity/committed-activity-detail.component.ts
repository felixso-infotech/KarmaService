import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

@Component({
  selector: 'jhi-committed-activity-detail',
  templateUrl: './committed-activity-detail.component.html'
})
export class CommittedActivityDetailComponent implements OnInit {
  committedActivity: ICommittedActivity;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ committedActivity }) => {
      this.committedActivity = committedActivity;
    });
  }

  previousState() {
    window.history.back();
  }
}
