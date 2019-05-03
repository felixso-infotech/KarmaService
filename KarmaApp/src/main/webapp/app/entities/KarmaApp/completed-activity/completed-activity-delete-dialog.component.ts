import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';
import { CompletedActivityService } from './completed-activity.service';

@Component({
  selector: 'jhi-completed-activity-delete-dialog',
  templateUrl: './completed-activity-delete-dialog.component.html'
})
export class CompletedActivityDeleteDialogComponent {
  completedActivity: ICompletedActivity;

  constructor(
    private completedActivityService: CompletedActivityService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.completedActivityService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'completedActivityListModification',
        content: 'Deleted an completedActivity'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-completed-activity-delete-popup',
  template: ''
})
export class CompletedActivityDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ completedActivity }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CompletedActivityDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.completedActivity = completedActivity;
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
