/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { CompletedChallengeUpdateComponent } from 'app/entities/Karma/completed-challenge/completed-challenge-update.component';
import { CompletedChallengeService } from 'app/entities/Karma/completed-challenge/completed-challenge.service';
import { CompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

describe('Component Tests', () => {
  describe('CompletedChallenge Management Update Component', () => {
    let comp: CompletedChallengeUpdateComponent;
    let fixture: ComponentFixture<CompletedChallengeUpdateComponent>;
    let service: CompletedChallengeService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [CompletedChallengeUpdateComponent]
      })
        .overrideTemplate(CompletedChallengeUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CompletedChallengeUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CompletedChallengeService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new CompletedChallenge(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.completedChallenge = entity;
          // WHEN
          comp.save();
          tick(); // simulate async

          // THEN
          expect(service.update).toHaveBeenCalledWith(entity);
          expect(comp.isSaving).toEqual(false);
        })
      );

      it(
        'Should call create service on save for new entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new CompletedChallenge();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.completedChallenge = entity;
          // WHEN
          comp.save();
          tick(); // simulate async

          // THEN
          expect(service.create).toHaveBeenCalledWith(entity);
          expect(comp.isSaving).toEqual(false);
        })
      );
    });
  });
});
