/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ActivityService } from 'app/entities/Karma/activity/activity.service';
import { IActivity, Activity, Type, ProofType } from 'app/shared/model/Karma/activity.model';

describe('Service Tests', () => {
  describe('Activity Service', () => {
    let injector: TestBed;
    let service: ActivityService;
    let httpMock: HttpTestingController;
    let elemDefault: IActivity;
    let currentDate: moment.Moment;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      injector = getTestBed();
      service = injector.get(ActivityService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new Activity(0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', Type.SINGLE, currentDate, ProofType.IMAGE, false, 0);
    });

    describe('Service methods', async () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            createdDateAndTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        service
          .find(123)
          .pipe(take(1))
          .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(JSON.stringify(returnedFromService));
      });

      it('should create a Activity', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            createdDateAndTime: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createdDateAndTime: currentDate
          },
          returnedFromService
        );
        service
          .create(new Activity(null))
          .pipe(take(1))
          .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(JSON.stringify(returnedFromService));
      });

      it('should update a Activity', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            description: 'BBBBBB',
            successMessage: 'BBBBBB',
            type: 'BBBBBB',
            createdDateAndTime: currentDate.format(DATE_TIME_FORMAT),
            proofType: 'BBBBBB',
            isMultipleProofsRequired: true,
            noOfPages: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            createdDateAndTime: currentDate
          },
          returnedFromService
        );
        service
          .update(expected)
          .pipe(take(1))
          .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(JSON.stringify(returnedFromService));
      });

      it('should return a list of Activity', async () => {
        const returnedFromService = Object.assign(
          {
            title: 'BBBBBB',
            description: 'BBBBBB',
            successMessage: 'BBBBBB',
            type: 'BBBBBB',
            createdDateAndTime: currentDate.format(DATE_TIME_FORMAT),
            proofType: 'BBBBBB',
            isMultipleProofsRequired: true,
            noOfPages: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            createdDateAndTime: currentDate
          },
          returnedFromService
        );
        service
          .query(expected)
          .pipe(
            take(1),
            map(resp => resp.body)
          )
          .subscribe(body => expect(body).toContainEqual(expected));
        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(JSON.stringify([returnedFromService]));
        httpMock.verify();
      });

      it('should delete a Activity', async () => {
        const rxPromise = service.delete(123).subscribe(resp => expect(resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});