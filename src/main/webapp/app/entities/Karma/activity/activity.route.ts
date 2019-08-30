import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Activity } from 'app/shared/model/Karma/activity.model';
import { ActivityService } from './activity.service';
import { ActivityComponent } from './activity.component';
import { ActivityDetailComponent } from './activity-detail.component';
import { ActivityUpdateComponent } from './activity-update.component';
import { ActivityDeletePopupComponent } from './activity-delete-dialog.component';
import { IActivity } from 'app/shared/model/Karma/activity.model';

@Injectable({ providedIn: 'root' })
export class ActivityResolve implements Resolve<IActivity> {
  constructor(private service: ActivityService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Activity> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<Activity>) => response.ok),
        map((activity: HttpResponse<Activity>) => activity.body)
      );
    }
    return of(new Activity());
  }
}

export const activityRoute: Routes = [
  {
    path: 'activity',
    component: ActivityComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'Activities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'activity/:id/view',
    component: ActivityDetailComponent,
    resolve: {
      activity: ActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Activities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'activity/new',
    component: ActivityUpdateComponent,
    resolve: {
      activity: ActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Activities'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'activity/:id/edit',
    component: ActivityUpdateComponent,
    resolve: {
      activity: ActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Activities'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const activityPopupRoute: Routes = [
  {
    path: 'activity/:id/delete',
    component: ActivityDeletePopupComponent,
    resolve: {
      activity: ActivityResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Activities'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
