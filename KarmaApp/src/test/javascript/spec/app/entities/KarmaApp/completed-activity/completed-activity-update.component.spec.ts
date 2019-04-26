/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { KarmaAppTestModule } from '../../../../test.module';
import { CompletedActivityUpdateComponent } from 'app/entities/KarmaApp/completed-activity/completed-activity-update.component';
import { CompletedActivityService } from 'app/entities/KarmaApp/completed-activity/completed-activity.service';
import { CompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

describe('Component Tests', () => {
  describe('CompletedActivity Management Update Component', () => {
    let comp: CompletedActivityUpdateComponent;
    let fixture: ComponentFixture<CompletedActivityUpdateComponent>;
    let service: CompletedActivityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [CompletedActivityUpdateComponent]
      })
        .overrideTemplate(CompletedActivityUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CompletedActivityUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CompletedActivityService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new CompletedActivity(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.completedActivity = entity;
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
          const entity = new CompletedActivity();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.completedActivity = entity;
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
