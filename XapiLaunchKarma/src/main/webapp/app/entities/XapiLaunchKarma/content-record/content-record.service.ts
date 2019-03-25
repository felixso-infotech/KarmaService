import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

type EntityResponseType = HttpResponse<IContentRecord>;
type EntityArrayResponseType = HttpResponse<IContentRecord[]>;

@Injectable({ providedIn: 'root' })
export class ContentRecordService {
  public resourceUrl = SERVER_API_URL + 'api/content-records';

  constructor(private http: HttpClient) {}

  create(contentRecord: IContentRecord): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(contentRecord);
    return this.http
      .post<IContentRecord>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(contentRecord: IContentRecord): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(contentRecord);
    return this.http
      .put<IContentRecord>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: string): Observable<EntityResponseType> {
    return this.http
      .get<IContentRecord>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IContentRecord[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: string): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(contentRecord: IContentRecord): IContentRecord {
    const copy: IContentRecord = Object.assign({}, contentRecord, {
      accessed: contentRecord.accessed != null && contentRecord.accessed.isValid() ? contentRecord.accessed.toJSON() : null,
      created: contentRecord.created != null && contentRecord.created.isValid() ? contentRecord.created.toJSON() : null
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.accessed = res.body.accessed != null ? moment(res.body.accessed) : null;
      res.body.created = res.body.created != null ? moment(res.body.created) : null;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((contentRecord: IContentRecord) => {
        contentRecord.accessed = contentRecord.accessed != null ? moment(contentRecord.accessed) : null;
        contentRecord.created = contentRecord.created != null ? moment(contentRecord.created) : null;
      });
    }
    return res;
  }
}
