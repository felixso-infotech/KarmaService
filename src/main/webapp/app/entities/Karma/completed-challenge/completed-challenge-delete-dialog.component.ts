import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';
import { CompletedChallengeService } from './completed-challenge.service';

@Component({
  selector: 'jhi-completed-challenge-delete-dialog',
  templateUrl: './completed-challenge-delete-dialog.component.html'
})
export class CompletedChallengeDeleteDialogComponent {
  completedChallenge: ICompletedChallenge;

  constructor(
    private completedChallengeService: CompletedChallengeService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.completedChallengeService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'completedChallengeListModification',
        content: 'Deleted an completedChallenge'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-completed-challenge-delete-popup',
  template: ''
})
export class CompletedChallengeDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ completedChallenge }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CompletedChallengeDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.completedChallenge = completedChallenge;
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
