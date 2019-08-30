/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { CompletedChallengeDetailComponent } from 'app/entities/Karma/completed-challenge/completed-challenge-detail.component';
import { CompletedChallenge } from 'app/shared/model/Karma/completed-challenge.model';

describe('Component Tests', () => {
  describe('CompletedChallenge Management Detail Component', () => {
    let comp: CompletedChallengeDetailComponent;
    let fixture: ComponentFixture<CompletedChallengeDetailComponent>;
    const route = ({ data: of({ completedChallenge: new CompletedChallenge(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [CompletedChallengeDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CompletedChallengeDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CompletedChallengeDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.completedChallenge).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
