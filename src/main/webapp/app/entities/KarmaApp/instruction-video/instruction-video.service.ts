import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';

type EntityResponseType = HttpResponse<IInstructionVideo>;
type EntityArrayResponseType = HttpResponse<IInstructionVideo[]>;

@Injectable({ providedIn: 'root' })
export class InstructionVideoService {
  public resourceUrl = SERVER_API_URL + 'api/instruction-videos';

  constructor(private http: HttpClient) {}

  create(instructionVideo: IInstructionVideo): Observable<EntityResponseType> {
    return this.http.post<IInstructionVideo>(this.resourceUrl, instructionVideo, { observe: 'response' });
  }

  update(instructionVideo: IInstructionVideo): Observable<EntityResponseType> {
    return this.http.put<IInstructionVideo>(this.resourceUrl, instructionVideo, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IInstructionVideo>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IInstructionVideo[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
