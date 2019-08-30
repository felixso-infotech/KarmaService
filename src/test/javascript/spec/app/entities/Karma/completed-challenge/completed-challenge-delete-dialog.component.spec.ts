/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { KarmaTestModule } from '../../../../test.module';
import { CompletedChallengeDeleteDialogComponent } from 'app/entities/Karma/completed-challenge/completed-challenge-delete-dialog.component';
import { CompletedChallengeService } from 'app/entities/Karma/completed-challenge/completed-challenge.service';

describe('Component Tests', () => {
  describe('CompletedChallenge Management Delete Component', () => {
    let comp: CompletedChallengeDeleteDialogComponent;
    let fixture: ComponentFixture<CompletedChallengeDeleteDialogComponent>;
    let service: CompletedChallengeService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [CompletedChallengeDeleteDialogComponent]
      })
        .overrideTemplate(CompletedChallengeDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CompletedChallengeDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CompletedChallengeService);
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
