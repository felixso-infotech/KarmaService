/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaAppTestModule } from '../../../../test.module';
import { CompletedActivityDetailComponent } from 'app/entities/KarmaApp/completed-activity/completed-activity-detail.component';
import { CompletedActivity } from 'app/shared/model/KarmaApp/completed-activity.model';

describe('Component Tests', () => {
  describe('CompletedActivity Management Detail Component', () => {
    let comp: CompletedActivityDetailComponent;
    let fixture: ComponentFixture<CompletedActivityDetailComponent>;
    const route = ({ data: of({ completedActivity: new CompletedActivity(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [CompletedActivityDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CompletedActivityDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CompletedActivityDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.completedActivity).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
