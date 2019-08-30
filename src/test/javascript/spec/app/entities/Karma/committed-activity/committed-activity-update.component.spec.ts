/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { CommittedActivityUpdateComponent } from 'app/entities/Karma/committed-activity/committed-activity-update.component';
import { CommittedActivityService } from 'app/entities/Karma/committed-activity/committed-activity.service';
import { CommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

describe('Component Tests', () => {
  describe('CommittedActivity Management Update Component', () => {
    let comp: CommittedActivityUpdateComponent;
    let fixture: ComponentFixture<CommittedActivityUpdateComponent>;
    let service: CommittedActivityService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [CommittedActivityUpdateComponent]
      })
        .overrideTemplate(CommittedActivityUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CommittedActivityUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CommittedActivityService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new CommittedActivity(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.committedActivity = entity;
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
          const entity = new CommittedActivity();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.committedActivity = entity;
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
