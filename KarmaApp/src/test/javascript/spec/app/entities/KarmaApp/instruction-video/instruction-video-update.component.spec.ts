/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { KarmaAppTestModule } from '../../../../test.module';
import { InstructionVideoUpdateComponent } from 'app/entities/KarmaApp/instruction-video/instruction-video-update.component';
import { InstructionVideoService } from 'app/entities/KarmaApp/instruction-video/instruction-video.service';
import { InstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';

describe('Component Tests', () => {
  describe('InstructionVideo Management Update Component', () => {
    let comp: InstructionVideoUpdateComponent;
    let fixture: ComponentFixture<InstructionVideoUpdateComponent>;
    let service: InstructionVideoService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [InstructionVideoUpdateComponent]
      })
        .overrideTemplate(InstructionVideoUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(InstructionVideoUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(InstructionVideoService);
    });

    describe('save', () => {
      it(
        'Should call update service on save for existing entity',
        fakeAsync(() => {
          // GIVEN
          const entity = new InstructionVideo(123);
          spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.instructionVideo = entity;
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
          const entity = new InstructionVideo();
          spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
          comp.instructionVideo = entity;
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
