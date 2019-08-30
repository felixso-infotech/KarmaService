import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';

@Component({
  selector: 'jhi-introduction-story-detail',
  templateUrl: './introduction-story-detail.component.html'
})
export class IntroductionStoryDetailComponent implements OnInit {
  introductionStory: IIntroductionStory;

  constructor(private dataUtils: JhiDataUtils, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ introductionStory }) => {
      this.introductionStory = introductionStory;
    });
  }

  byteSize(field) {
    return this.dataUtils.byteSize(field);
  }

  openFile(contentType, field) {
    return this.dataUtils.openFile(contentType, field);
  }
  previousState() {
    window.history.back();
  }
}
