import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IChallenge } from 'app/shared/model/Karma/challenge.model';
import { ChallengeService } from './challenge.service';

@Component({
  selector: 'jhi-challenge-delete-dialog',
  templateUrl: './challenge-delete-dialog.component.html'
})
export class ChallengeDeleteDialogComponent {
  challenge: IChallenge;

  constructor(private challengeService: ChallengeService, public activeModal: NgbActiveModal, private eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.challengeService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'challengeListModification',
        content: 'Deleted an challenge'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-challenge-delete-popup',
  template: ''
})
export class ChallengeDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ challenge }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(ChallengeDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.challenge = challenge;
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
