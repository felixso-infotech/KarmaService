/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { IntroductionStoryUpdateComponent } from 'app/entities/Karma/introduction-story/introduction-story-update.component';
import { IntroductionStoryService } from 'app/entities/Karma/introduction-story/introduction-story.service';
import { IntroductionStory } from 'app/shared/model/Karma/introduction-story.model';

describe('Component Tests', () => {
  describe('IntroductionStory Management Update Component', () => {
    let comp: IntroductionStoryUpdateComponent;
    let fixture: ComponentFixture<IntroductionStoryUpdateComponent>;
    let service: IntroductionStoryService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [IntroductionStoryUpdateComponent]
      })
        .overrideTemplate(IntroductionStoryUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(IntroductionStoryUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IntroductionStoryService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new IntroductionStory(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.introductionStory = entity;
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
          const entity = new IntroductionStory();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.introductionStory = entity;
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
