/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ContentRecordService } from 'app/entities/XapiLaunchKarma/content-record/content-record.service';
import { IContentRecord, ContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

describe('Service Tests', () => {
  describe('ContentRecord Service', () => {
    let injector: TestBed;
    let service: ContentRecordService;
    let httpMock: HttpTestingController;
    let elemDefault: IContentRecord;
    let currentDate: moment.Moment;
    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      injector = getTestBed();
      service = injector.get(ContentRecordService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new ContentRecord(
        'ID',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0
      );
    });

    describe('Service methods', async () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            accessed: currentDate.format(DATE_TIME_FORMAT),
            created: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        service
          .find('123')
          .pipe(take(1))
          .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(JSON.stringify(returnedFromService));
      });

      it('should create a ContentRecord', async () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
            accessed: currentDate.format(DATE_TIME_FORMAT),
            created: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            accessed: currentDate,
            created: currentDate
          },
          returnedFromService
        );
        service
          .create(new ContentRecord(null))
          .pipe(take(1))
          .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(JSON.stringify(returnedFromService));
      });

      it('should update a ContentRecord', async () => {
        const returnedFromService = Object.assign(
          {
            iconURL: 'BBBBBB',
            packageLink: 'BBBBBB',
            launchType: 'BBBBBB',
            owner: 'BBBBBB',
            accessed: currentDate.format(DATE_TIME_FORMAT),
            created: currentDate.format(DATE_TIME_FORMAT),
            description: 'BBBBBB',
            title: 'BBBBBB',
            url: 'BBBBBB',
            v: 1,
            launches: 1,
            customData: 'BBBBBB',
            mediaTypeKey: 'BBBBBB',
            publicKey: 'BBBBBB',
            sessionLength: 1,
            timeToConsume: 1
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            accessed: currentDate,
            created: currentDate
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

      it('should return a list of ContentRecord', async () => {
        const returnedFromService = Object.assign(
          {
            iconURL: 'BBBBBB',
            packageLink: 'BBBBBB',
            launchType: 'BBBBBB',
            owner: 'BBBBBB',
            accessed: currentDate.format(DATE_TIME_FORMAT),
            created: currentDate.format(DATE_TIME_FORMAT),
            description: 'BBBBBB',
            title: 'BBBBBB',
            url: 'BBBBBB',
            v: 1,
            launches: 1,
            customData: 'BBBBBB',
            mediaTypeKey: 'BBBBBB',
            publicKey: 'BBBBBB',
            sessionLength: 1,
            timeToConsume: 1
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            accessed: currentDate,
            created: currentDate
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

      it('should delete a ContentRecord', async () => {
        const rxPromise = service.delete('123').subscribe(resp => expect(resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
