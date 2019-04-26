import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

@Component({
  selector: 'jhi-completed-activity-detail',
  templateUrl: './completed-activity-detail.component.html'
})
export class CompletedActivityDetailComponent implements OnInit {
  completedActivity: ICompletedActivity;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ completedActivity }) => {
      this.completedActivity = completedActivity;
    });
  }

  previousState() {
    window.history.back();
  }
}
