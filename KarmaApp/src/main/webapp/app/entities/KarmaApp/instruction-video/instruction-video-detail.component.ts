import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';

@Component({
  selector: 'jhi-instruction-video-detail',
  templateUrl: './instruction-video-detail.component.html'
})
export class InstructionVideoDetailComponent implements OnInit {
  instructionVideo: IInstructionVideo;

  constructor(private dataUtils: JhiDataUtils, private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ instructionVideo }) => {
      this.instructionVideo = instructionVideo;
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
