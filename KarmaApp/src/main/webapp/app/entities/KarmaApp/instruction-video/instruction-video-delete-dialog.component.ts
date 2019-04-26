import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';
import { InstructionVideoService } from './instruction-video.service';

@Component({
  selector: 'jhi-instruction-video-delete-dialog',
  templateUrl: './instruction-video-delete-dialog.component.html'
})
export class InstructionVideoDeleteDialogComponent {
  instructionVideo: IInstructionVideo;

  constructor(
    private instructionVideoService: InstructionVideoService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.instructionVideoService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'instructionVideoListModification',
        content: 'Deleted an instructionVideo'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-instruction-video-delete-popup',
  template: ''
})
export class InstructionVideoDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ instructionVideo }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(InstructionVideoDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.instructionVideo = instructionVideo;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
