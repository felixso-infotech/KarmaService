/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { IntroductionStoryDetailComponent } from 'app/entities/Karma/introduction-story/introduction-story-detail.component';
import { IntroductionStory } from 'app/shared/model/Karma/introduction-story.model';

describe('Component Tests', () => {
  describe('IntroductionStory Management Detail Component', () => {
    let comp: IntroductionStoryDetailComponent;
    let fixture: ComponentFixture<IntroductionStoryDetailComponent>;
    const route = ({ data: of({ introductionStory: new IntroductionStory(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [IntroductionStoryDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(IntroductionStoryDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(IntroductionStoryDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.introductionStory).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
