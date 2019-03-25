import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

@Component({
  selector: 'jhi-content-record-detail',
  templateUrl: './content-record-detail.component.html'
})
export class ContentRecordDetailComponent implements OnInit {
  contentRecord: IContentRecord;

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ contentRecord }) => {
      this.contentRecord = contentRecord;
    });
  }

  previousState() {
    window.history.back();
  }
}
