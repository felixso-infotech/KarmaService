import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';
import { ContentRecordService } from './content-record.service';
import { ContentRecordComponent } from './content-record.component';
import { ContentRecordDetailComponent } from './content-record-detail.component';
import { ContentRecordUpdateComponent } from './content-record-update.component';
import { ContentRecordDeletePopupComponent } from './content-record-delete-dialog.component';
import { IContentRecord } from 'app/shared/model/XapiLaunchKarma/content-record.model';

@Injectable({ providedIn: 'root' })
export class ContentRecordResolve implements Resolve<IContentRecord> {
  constructor(private service: ContentRecordService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ContentRecord> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<ContentRecord>) => response.ok),
        map((contentRecord: HttpResponse<ContentRecord>) => contentRecord.body)
      );
    }
    return of(new ContentRecord());
  }
}

export const contentRecordRoute: Routes = [
  {
    path: 'content-record',
    component: ContentRecordComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'ContentRecords'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'content-record/:id/view',
    component: ContentRecordDetailComponent,
    resolve: {
      contentRecord: ContentRecordResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'ContentRecords'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'content-record/new',
    component: ContentRecordUpdateComponent,
    resolve: {
      contentRecord: ContentRecordResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'ContentRecords'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'content-record/:id/edit',
    component: ContentRecordUpdateComponent,
    resolve: {
      contentRecord: ContentRecordResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'ContentRecords'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const contentRecordPopupRoute: Routes = [
  {
    path: 'content-record/:id/delete',
    component: ContentRecordDeletePopupComponent,
    resolve: {
      contentRecord: ContentRecordResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'ContentRecords'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
