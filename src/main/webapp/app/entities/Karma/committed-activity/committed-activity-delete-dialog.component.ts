import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICommittedActivity } from 'app/shared/model/Karma/committed-activity.model';
import { CommittedActivityService } from './committed-activity.service';

@Component({
  selector: 'jhi-committed-activity-delete-dialog',
  templateUrl: './committed-activity-delete-dialog.component.html'
})
export class CommittedActivityDeleteDialogComponent {
  committedActivity: ICommittedActivity;

  constructor(
    private committedActivityService: CommittedActivityService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.committedActivityService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'committedActivityListModification',
        content: 'Deleted an committedActivity'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-committed-activity-delete-popup',
  template: ''
})
export class CommittedActivityDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ committedActivity }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CommittedActivityDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.committedActivity = committedActivity;
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
