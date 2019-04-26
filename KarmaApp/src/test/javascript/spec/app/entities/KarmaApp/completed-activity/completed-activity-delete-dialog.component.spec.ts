/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { KarmaAppTestModule } from '../../../../test.module';
import { CompletedActivityDeleteDialogComponent } from 'app/entities/KarmaApp/completed-activity/completed-activity-delete-dialog.component';
import { CompletedActivityService } from 'app/entities/KarmaApp/completed-activity/completed-activity.service';

describe('Component Tests', () => {
  describe('CompletedActivity Management Delete Component', () => {
    let comp: CompletedActivityDeleteDialogComponent;
    let fixture: ComponentFixture<CompletedActivityDeleteDialogComponent>;
    let service: CompletedActivityService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [CompletedActivityDeleteDialogComponent]
      })
        .overrideTemplate(CompletedActivityDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CompletedActivityDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CompletedActivityService);
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
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
