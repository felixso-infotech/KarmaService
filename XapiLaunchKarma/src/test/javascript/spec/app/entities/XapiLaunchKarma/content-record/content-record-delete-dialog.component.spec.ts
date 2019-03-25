/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { XapiLaunchKarmaTestModule } from '../../../../test.module';
import { ContentRecordDeleteDialogComponent } from 'app/entities/XapiLaunchKarma/content-record/content-record-delete-dialog.component';
import { ContentRecordService } from 'app/entities/XapiLaunchKarma/content-record/content-record.service';

describe('Component Tests', () => {
  describe('ContentRecord Management Delete Component', () => {
    let comp: ContentRecordDeleteDialogComponent;
    let fixture: ComponentFixture<ContentRecordDeleteDialogComponent>;
    let service: ContentRecordService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [XapiLaunchKarmaTestModule],
        declarations: [ContentRecordDeleteDialogComponent]
      })
        .overrideTemplate(ContentRecordDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ContentRecordDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ContentRecordService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete('123');
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith('123');
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
