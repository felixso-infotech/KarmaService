import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';
import { IntroductionStoryService } from './introduction-story.service';

@Component({
  selector: 'jhi-introduction-story-delete-dialog',
  templateUrl: './introduction-story-delete-dialog.component.html'
})
export class IntroductionStoryDeleteDialogComponent {
  introductionStory: IIntroductionStory;

  constructor(
    private introductionStoryService: IntroductionStoryService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.introductionStoryService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'introductionStoryListModification',
        content: 'Deleted an introductionStory'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-introduction-story-delete-popup',
  template: ''
})
export class IntroductionStoryDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ introductionStory }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(IntroductionStoryDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.introductionStory = introductionStory;
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
