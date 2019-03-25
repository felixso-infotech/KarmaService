import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';
import { ContentRecordService } from './content-record.service';

@Component({
  selector: 'jhi-content-record-delete-dialog',
  templateUrl: './content-record-delete-dialog.component.html'
})
export class ContentRecordDeleteDialogComponent {
  contentRecord: IContentRecord;

  constructor(
    private contentRecordService: ContentRecordService,
    public activeModal: NgbActiveModal,
    private eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: string) {
    this.contentRecordService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'contentRecordListModification',
        content: 'Deleted an contentRecord'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-content-record-delete-popup',
  template: ''
})
export class ContentRecordDeletePopupComponent implements OnInit, OnDestroy {
  private ngbModalRef: NgbModalRef;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ contentRecord }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(ContentRecordDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.contentRecord = contentRecord;
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
