/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { KarmaTestModule } from '../../../../test.module';
import { IntroductionStoryDeleteDialogComponent } from 'app/entities/Karma/introduction-story/introduction-story-delete-dialog.component';
import { IntroductionStoryService } from 'app/entities/Karma/introduction-story/introduction-story.service';

describe('Component Tests', () => {
  describe('IntroductionStory Management Delete Component', () => {
    let comp: IntroductionStoryDeleteDialogComponent;
    let fixture: ComponentFixture<IntroductionStoryDeleteDialogComponent>;
    let service: IntroductionStoryService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [IntroductionStoryDeleteDialogComponent]
      })
        .overrideTemplate(IntroductionStoryDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(IntroductionStoryDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IntroductionStoryService);
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
