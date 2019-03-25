import { Moment } from 'moment';

export interface IContentRecord {
  id?: string;
  iconURL?: string;
  packageLink?: string;
  launchType?: string;
  owner?: string;
  accessed?: Moment;
  created?: Moment;
  description?: string;
  title?: string;
  url?: string;
  v?: number;
  launches?: number;
  customData?: string;
  mediaTypeKey?: string;
  publicKey?: string;
  sessionLength?: number;
  timeToConsume?: number;
}

export class ContentRecord implements IContentRecord {
  constructor(
    public id?: string,
    public iconURL?: string,
    public packageLink?: string,
    public launchType?: string,
    public owner?: string,
    public accessed?: Moment,
    public created?: Moment,
    public description?: string,
    public title?: string,
    public url?: string,
    public v?: number,
    public launches?: number,
    public customData?: string,
    public mediaTypeKey?: string,
    public publicKey?: string,
    public sessionLength?: number,
    public timeToConsume?: number
  ) {}
}
