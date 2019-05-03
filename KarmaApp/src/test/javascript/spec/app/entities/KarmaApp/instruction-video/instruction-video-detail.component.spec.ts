/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaAppTestModule } from '../../../../test.module';
import { InstructionVideoDetailComponent } from 'app/entities/KarmaApp/instruction-video/instruction-video-detail.component';
import { InstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';

describe('Component Tests', () => {
  describe('InstructionVideo Management Detail Component', () => {
    let comp: InstructionVideoDetailComponent;
    let fixture: ComponentFixture<InstructionVideoDetailComponent>;
    const route = ({ data: of({ instructionVideo: new InstructionVideo(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [InstructionVideoDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(InstructionVideoDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(InstructionVideoDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.instructionVideo).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
