import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { IntroductionStory } from 'app/shared/model/Karma/introduction-story.model';
import { IntroductionStoryService } from './introduction-story.service';
import { IntroductionStoryComponent } from './introduction-story.component';
import { IntroductionStoryDetailComponent } from './introduction-story-detail.component';
import { IntroductionStoryUpdateComponent } from './introduction-story-update.component';
import { IntroductionStoryDeletePopupComponent } from './introduction-story-delete-dialog.component';
import { IIntroductionStory } from 'app/shared/model/Karma/introduction-story.model';

@Injectable({ providedIn: 'root' })
export class IntroductionStoryResolve implements Resolve<IIntroductionStory> {
  constructor(private service: IntroductionStoryService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IntroductionStory> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<IntroductionStory>) => response.ok),
        map((introductionStory: HttpResponse<IntroductionStory>) => introductionStory.body)
      );
    }
    return of(new IntroductionStory());
  }
}

export const introductionStoryRoute: Routes = [
  {
    path: 'introduction-story',
    component: IntroductionStoryComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'IntroductionStories'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'introduction-story/:id/view',
    component: IntroductionStoryDetailComponent,
    resolve: {
      introductionStory: IntroductionStoryResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'IntroductionStories'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'introduction-story/new',
    component: IntroductionStoryUpdateComponent,
    resolve: {
      introductionStory: IntroductionStoryResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'IntroductionStories'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'introduction-story/:id/edit',
    component: IntroductionStoryUpdateComponent,
    resolve: {
      introductionStory: IntroductionStoryResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'IntroductionStories'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const introductionStoryPopupRoute: Routes = [
  {
    path: 'introduction-story/:id/delete',
    component: IntroductionStoryDeletePopupComponent,
    resolve: {
      introductionStory: IntroductionStoryResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'IntroductionStories'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
