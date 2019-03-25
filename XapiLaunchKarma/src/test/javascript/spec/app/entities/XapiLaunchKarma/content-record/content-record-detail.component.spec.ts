/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { XapiLaunchKarmaTestModule } from '../../../../test.module';
import { ContentRecordDetailComponent } from 'app/entities/XapiLaunchKarma/content-record/content-record-detail.component';
import { ContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

describe('Component Tests', () => {
  describe('ContentRecord Management Detail Component', () => {
    let comp: ContentRecordDetailComponent;
    let fixture: ComponentFixture<ContentRecordDetailComponent>;
    const route = ({ data: of({ contentRecord: new ContentRecord('123') }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [XapiLaunchKarmaTestModule],
        declarations: [ContentRecordDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ContentRecordDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ContentRecordDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.contentRecord).toEqual(jasmine.objectContaining({ id: '123' }));
      });
    });
  });
});
