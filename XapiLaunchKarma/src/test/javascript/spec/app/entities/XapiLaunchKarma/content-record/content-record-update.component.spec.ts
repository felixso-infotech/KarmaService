/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { XapiLaunchKarmaTestModule } from '../../../../test.module';
import { ContentRecordUpdateComponent } from 'app/entities/XapiLaunchKarma/content-record/content-record-update.component';
import { ContentRecordService } from 'app/entities/XapiLaunchKarma/content-record/content-record.service';
import { ContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

describe('Component Tests', () => {
  describe('ContentRecord Management Update Component', () => {
    let comp: ContentRecordUpdateComponent;
    let fixture: ComponentFixture<ContentRecordUpdateComponent>;
    let service: ContentRecordService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [XapiLaunchKarmaTestModule],
        declarations: [ContentRecordUpdateComponent]
      })
        .overrideTemplate(ContentRecordUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ContentRecordUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ContentRecordService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new ContentRecord('123');
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.contentRecord = entity;
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
          const entity = new ContentRecord();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.contentRecord = entity;
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
