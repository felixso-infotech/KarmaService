import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { InstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';
import { InstructionVideoService } from './instruction-video.service';
import { InstructionVideoComponent } from './instruction-video.component';
import { InstructionVideoDetailComponent } from './instruction-video-detail.component';
import { InstructionVideoUpdateComponent } from './instruction-video-update.component';
import { InstructionVideoDeletePopupComponent } from './instruction-video-delete-dialog.component';
import { IInstructionVideo } from 'app/shared/model/KarmaApp/instruction-video.model';

@Injectable({ providedIn: 'root' })
export class InstructionVideoResolve implements Resolve<IInstructionVideo> {
  constructor(private service: InstructionVideoService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<InstructionVideo> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id).pipe(
        filter((response: HttpResponse<InstructionVideo>) => response.ok),
        map((instructionVideo: HttpResponse<InstructionVideo>) => instructionVideo.body)
      );
    }
    return of(new InstructionVideo());
  }
}

export const instructionVideoRoute: Routes = [
  {
    path: 'instruction-video',
    component: InstructionVideoComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'InstructionVideos'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'instruction-video/:id/view',
    component: InstructionVideoDetailComponent,
    resolve: {
      instructionVideo: InstructionVideoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'InstructionVideos'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'instruction-video/new',
    component: InstructionVideoUpdateComponent,
    resolve: {
      instructionVideo: InstructionVideoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'InstructionVideos'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'instruction-video/:id/edit',
    component: InstructionVideoUpdateComponent,
    resolve: {
      instructionVideo: InstructionVideoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'InstructionVideos'
    },
    canActivate: [UserRouteAccessService]
  }
];

export const instructionVideoPopupRoute: Routes = [
  {
    path: 'instruction-video/:id/delete',
    component: InstructionVideoDeletePopupComponent,
    resolve: {
      instructionVideo: InstructionVideoResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'InstructionVideos'
    },
    canActivate: [UserRouteAccessService],
    outlet: 'popup'
  }
];
