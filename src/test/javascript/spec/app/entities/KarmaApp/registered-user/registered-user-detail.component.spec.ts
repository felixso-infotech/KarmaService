/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { KarmaAppTestModule } from '../../../../test.module';
import { RegisteredUserDetailComponent } from 'app/entities/KarmaApp/registered-user/registered-user-detail.component';
import { RegisteredUser } from 'app/shared/model/KarmaApp/registered-user.model';

describe('Component Tests', () => {
  describe('RegisteredUser Management Detail Component', () => {
    let comp: RegisteredUserDetailComponent;
    let fixture: ComponentFixture<RegisteredUserDetailComponent>;
    const route = ({ data: of({ registeredUser: new RegisteredUser(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [KarmaAppTestModule],
        declarations: [RegisteredUserDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(RegisteredUserDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(RegisteredUserDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.registeredUser).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
