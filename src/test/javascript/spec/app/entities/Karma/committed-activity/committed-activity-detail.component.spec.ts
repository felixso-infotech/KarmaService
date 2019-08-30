/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaTestModule } from '../../../../test.module';
import { CommittedActivityDetailComponent } from 'app/entities/Karma/committed-activity/committed-activity-detail.component';
import { CommittedActivity } from 'app/shared/model/Karma/committed-activity.model';

describe('Component Tests', () => {
  describe('CommittedActivity Management Detail Component', () => {
    let comp: CommittedActivityDetailComponent;
    let fixture: ComponentFixture<CommittedActivityDetailComponent>;
    const route = ({ data: of({ committedActivity: new CommittedActivity(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaTestModule],
        declarations: [CommittedActivityDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CommittedActivityDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CommittedActivityDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.committedActivity).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
