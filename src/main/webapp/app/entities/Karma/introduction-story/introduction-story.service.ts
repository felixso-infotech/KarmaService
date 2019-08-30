import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';

type EntityResponseType = HttpResponse<IIntroductionStory>;
type EntityArrayResponseType = HttpResponse<IIntroductionStory[]>;

@Injectable({ providedIn: 'root' })
export class IntroductionStoryService {
  public resourceUrl = SERVER_API_URL + 'api/introduction-stories';

  constructor(private http: HttpClient) {}

  create(introductionStory: IIntroductionStory): Observable<EntityResponseType> {
    return this.http.post<IIntroductionStory>(this.resourceUrl, introductionStory, { observe: 'response' });
  }

  update(introductionStory: IIntroductionStory): Observable<EntityResponseType> {
    return this.http.put<IIntroductionStory>(this.resourceUrl, introductionStory, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IIntroductionStory>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IIntroductionStory[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
